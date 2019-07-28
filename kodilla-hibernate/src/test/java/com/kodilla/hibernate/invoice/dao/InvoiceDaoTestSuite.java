package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ItemDao itemDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Item item1 = new Item(BigDecimal.valueOf(6),3,BigDecimal.valueOf(18));
        Item item2 = new Item(BigDecimal.valueOf(3),1,BigDecimal.valueOf(3));
        Item item3 = new Item(BigDecimal.valueOf(1),2,BigDecimal.valueOf(2));
        Item item4 = new Item(BigDecimal.valueOf(3.5),1,BigDecimal.valueOf(3.5));


        Product product1 = new Product("product 1");
        Product product2 = new Product("product 2");
        Product product3 = new Product("product 3");

        product1.getItemP().add(item1);
        product2.getItemP().add(item2);
        product3.getItemP().add(item4);
        product1.getItemP().add(item3);

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product1);
        item4.setProduct(product3);

        Invoice invoice = new Invoice("FV-123456");

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);

        int invoiceId = invoice.getId();
        Optional<Invoice> invoiceOptional = invoiceDao.findById(invoiceId);

        //Then
        Assert.assertEquals(1,invoiceDao.count());
        Assert.assertEquals(4, itemDao.count());
        Assert.assertEquals(4,invoice.getItems().size());
        Assert.assertTrue(invoiceOptional.isPresent());
        Invoice invoiceFromDb = invoiceOptional.get();
        Assert.assertEquals(4, invoiceFromDb.getItems().size());


        //CleanUp
        invoiceDao.deleteAll();
    }
}
