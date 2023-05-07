package org.app.Customer;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Setter
@Accessors(fluent = true)
public class CustomerBuilder {
    @NotNull Customer customer;
    @NotNull String name;
    @NotNull String telephoneNumber;
    private double point;
    private boolean status;

    public CustomerBuilder(Customer customer) {
        this.customer = customer;
        this.name = "";
        this.telephoneNumber = "";
        this.point = 0;
        this.status = true;
    }

    public Customer build() {
        return customer;
    }
    public CustomerBuilder setMember() {
        this.customer = new Member(customer.getId(), customer.getBills(),
                this.name, this.telephoneNumber, this.point, this.status);
        return this;
    }
    public CustomerBuilder setVIP() {
        this.customer = new VIP(customer.getId(), customer.getBills(),
                this.name, this.telephoneNumber, this.point, this.status);
        return this;
    }
}
