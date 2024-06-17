package com.example.poc.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.client.RestTemplate;

@ShellComponent
public class RemoteCommandExecutor {

    private final RestTemplate restTemplate;
    private final String serverUrl = "http://localhost:8080/api/execute";

    @Autowired
    public RemoteCommandExecutor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @ShellMethod("Executes a command on the server")
    public String executeRemoteCommand(@ShellOption String command) {
        return restTemplate.postForObject(serverUrl, command, String.class);
    }
}
