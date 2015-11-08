package data;

import com.google.common.base.Preconditions;

/**
 * @author Bartłomiej Jańczak
 */
public class Client {
    private final String name;
    private final Address address;

    public Client(String name, Address address) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(address);

        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
