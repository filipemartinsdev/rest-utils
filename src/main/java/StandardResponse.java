import com.fasterxml.jackson.annotation.JsonInclude;

/*
* Template for API responses, following JSend pattern.
* **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StandardResponse<T> {
    public String status;
    public String message;
    public T data;

    private StandardResponse() {}

    private StandardResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> Builder<T> builder() {
        return new Builder<T>();
    }

    public static <T> StandardResponse<T> success(T data){
        return new StandardResponse<T>(Status.SUCCESS.label, null, data);
    }

    public static <T> StandardResponse<T> fail(String message, T data){
        return new StandardResponse<T>(Status.FAIL.label, message, data);
    }

    public static <T> StandardResponse<T> error(){
        return new StandardResponse<T>(Status.ERROR.label, null, null);
    }

    public static <T> StandardResponse<T> error(String message){
        return new StandardResponse<T>(Status.ERROR.label, message, null);
    }

    public static <T> StandardResponse<T> error(String message, T data){
        return new StandardResponse<T>(Status.ERROR.label, message, data);
    }

    private static enum Status {
        SUCCESS("success"), FAIL("fail"), ERROR("error");

        public final String label;

        Status(String label) {
            this.label = label;
        }
    }

    public static class Builder<T> {
        private String status;
        private String message;
        private T data;

        private Builder() {}

        public StandardResponse<T> build(){
            return new StandardResponse<T>(this.status, this.message, this.data);
        }

        public Builder<T> status(String status){
            this.status = status;
            return this;
        }

        public Builder<T> message(String message){
            this.message = message;
            return this;
        }

        public Builder<T> data(T data){
            this.data = data;
            return this;
        }
    }
}

