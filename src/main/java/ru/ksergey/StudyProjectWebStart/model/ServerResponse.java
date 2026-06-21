package ru.ksergey.StudyProjectWebStart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ServerResponse<T> {
    @JsonProperty("isSuccess")
    private boolean success;
    private HttpStatus statusCode;
    @JsonProperty("errors")
    private List<String> errorMessages;
    private T result;

    public ServerResponse() {
        this.success = true;
        this.errorMessages = new ArrayList<>();
    }
}
