package az.code.restapitask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private Integer errorCode;
    private String errorMessage;
    private String succesMessage;
    private Employee obj;
    public static ResponseDTO of(Employee obj) {
        ResponseDTO resp = new ResponseDTO();
        resp.setObj(obj);
        return resp;
    }

    public static ResponseDTO of(Employee obj, String succesMessage) {
        ResponseDTO resp = new ResponseDTO();
        resp.setObj(obj);
        resp.setSuccesMessage(succesMessage);
        return resp;
    }

    public static ResponseDTO of(Employee obj, Integer errorCode, String errorMessage) {
        ResponseDTO resp = new ResponseDTO();
        resp.setObj(obj);
        resp.setErrorCode(errorCode);
        resp.setErrorMessage(errorMessage);
        return resp;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "obj=" + obj +
                '}';
    }
}