package homework1;

public class FieldForJumping extends Course{
    private double fieldLength;

    public double getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(double fieldLength) {
        this.fieldLength = fieldLength;
    }

    public FieldForJumping(double fieldLength){
        this.setFieldLength(fieldLength) ;
    }

}
