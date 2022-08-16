package com.manuel.pokeapi.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.Generated;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import javax.net.ssl.SSLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Generated
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebClient webClient(WebClient.Builder builder) throws SSLException {
        final SslContext sslContextForTls12 = SslContextBuilder.forClient()
                .protocols("TLSv1.2")
                .build();

        TcpClient tcpClient = TcpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 600000)
                .secure(sslContextSpec -> sslContextSpec.sslContext(sslContextForTls12))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(600000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(600000, TimeUnit.MILLISECONDS)));

        HttpClient httpClient = HttpClient.from(tcpClient).disableRetry(false).responseTimeout(Duration.ofMinutes(10));

        return builder
                .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

}
