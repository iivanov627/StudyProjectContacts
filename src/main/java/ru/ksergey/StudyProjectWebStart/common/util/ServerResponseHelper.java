package ru.ksergey.StudyProjectWebStart.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.ksergey.StudyProjectWebStart.model.ServerResponse;

import java.util.ArrayList;
import java.util.List;

public class ServerResponseHelper {
    private static <T> ResponseEntity<ServerResponse<T>> response(
            T result,
            HttpStatus httpStatus){
        ServerResponse<T> response = ServerResponse.<T>builder()
                .result(result)
                .statusCode(httpStatus)
                .success(true)
                .errorMessages(new ArrayList<>())
                .build();
        return ResponseEntity.status(httpStatus).body(response);
    }


    public  static <T> ResponseEntity<ServerResponse<T>> ok(T result){
        return response(result, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ServerResponse<T>> created (T result){
        return response(result, HttpStatus.CREATED);
    }



    public  static <T> ResponseEntity<ServerResponse<T>> noContent (){
        return ResponseEntity.noContent().build();
    }

    private static <T> ResponseEntity<ServerResponse<T>> clientError(List<String> errorMessages,
                                                                    HttpStatus httpStatus){
        ServerResponse<T> response = ServerResponse.<T>builder()
                .result(null)
                .statusCode(httpStatus)
                .success(false)
                .errorMessages(errorMessages)
                .build();
        return ResponseEntity.status(httpStatus).body(response);
    }

    public static <T> ResponseEntity<ServerResponse<T>> notFound(List<String> errorMessages){
        return clientError(errorMessages,HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<ServerResponse<T>> conflict(
            List<String> errorMessages){
        return clientError(errorMessages,HttpStatus.CONFLICT);
    }

}
