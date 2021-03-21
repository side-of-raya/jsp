package DAO;

public class UpdateArgs {
    public UpdateArgs (String field, Object value) {
        this.field = field;
        this.value = value;
    };
    public String field;
    public Object value;
}
