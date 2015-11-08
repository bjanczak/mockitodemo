package data;

import com.google.common.base.Preconditions;

import java.util.List;

/**
 * @author Bartłomiej Jańczak
 */
public class Invoice {

    private final Client client;
    private final List<Item> itemsList;

    public Invoice(Client client, List<Item> itemsList) {
        Preconditions.checkNotNull(client);
        Preconditions.checkNotNull(itemsList);

        this.client = client;
        this.itemsList = itemsList;
    }

    public Client getClient() {
        return client;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }
}
