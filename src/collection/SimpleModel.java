package collection;

import java.util.Objects;

/**
 * @author JaneMin
 * @create 2018/9/3
 */
public class SimpleModel {
    private String modelName;
    private Integer modelValue;
    private boolean useful;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getModelValue() {
        return modelValue;
    }

    public void setModelValue(Integer modelValue) {
        this.modelValue = modelValue;
    }

    public boolean isUseful() {
        return useful;
    }

    public void setUseful(boolean useful) {
        this.useful = useful;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleModel)) return false;
        SimpleModel that = (SimpleModel) o;
        return useful == that.useful &&
                Objects.equals(modelName, that.modelName) &&
                Objects.equals(modelValue, that.modelValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, modelValue, useful);
    }
}
