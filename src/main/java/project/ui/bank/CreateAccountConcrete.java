package project.ui.bank;

import project.framwork.*;
import project.bank.*;
import project.framwork.model.Account;
import project.framwork.model.Customer;

public class CreateAccountConcrete extends TemplateToCreateAccount {
    public CreateAccountConcrete(AccountService accountService) {
        super(accountService);
    }

    @Override
    public Address createAddress(String street, String city, String state, String zip) {
        return new Address(street,city,state,zip);
    }

    @Override
    public Customer createCustomer(String name, String ID, String email, String dateOfBirth, Address address, String customerType) {
        if(customerType.equalsIgnoreCase("company")){
            return new CompanyAccount(name,ID,email,address,dateOfBirth);
        }else return new PersonalAccount(name,ID,email,dateOfBirth,address);
    }

    @Override
    public AccountType createAccountType(String accountType) {
        if(accountType.equalsIgnoreCase("Checking")){
            return new CheckingAccount();
        }else return new SavingAccount();
    }

    @Override
    public Account createAccount(Customer customer, AccountType accountType, String accountNumber) {
        return super.getAccountService().createAccount(customer,accountType,accountNumber);
    }
}
