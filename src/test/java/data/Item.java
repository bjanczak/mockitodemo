package data;

import com.google.common.base.Objects;

import java.math.BigDecimal;

/**
 * @author Bartłomiej Jańczak
 */
public class Item {

    private final String name;
    private final BigDecimal value;

    public Item(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equal(name, item.name) &&
                Objects.equal(value, item.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, value);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
