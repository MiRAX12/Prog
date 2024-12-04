package Exceptions;

public class IHaveNoPlate extends Exception {
    public IHaveNoPlate(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        // Вы можете модифицировать строку сообщения или добавить дополнительную информацию
        return " смотрит " + super.getMessage();
    }
}
