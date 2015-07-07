package com.softhis.service;

import com.softhis.dao.ClientDao;
import com.softhis.dto.ReportLineDto;
import com.softhis.dto.ReportOrderDto;
import com.softhis.model.Client;
import com.softhis.model.Order;
import com.softhis.model.OrderElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    private Random random = new Random();

    public List<ReportLineDto> getClientReport(int numberOfExpensiveListed) throws IllegalArgumentException {
        List<Client> clients = clientDao.getClients();
        List<ReportLineDto> result = new ArrayList<>();

        for (Client client : clients) {
            ReportLineDto reportLine = new ReportLineDto();

            reportLine.setFirstName(client.getFirstName());
            reportLine.setLastName(client.getLastName());

            int amount = 0;
            List<ReportOrderDto> reportOrders = new ArrayList<>();
            for (Order order : client.getOrders()) {
                amount += order.getOrderAmount();
                reportOrders.add(new ReportOrderDto(order.getOrderDate(), order.getOrderAmount()));
            }
            reportLine.setAmount(amount);

            Collections.sort(reportOrders, new Comparator<ReportOrderDto>() {
                @Override
                public int compare(ReportOrderDto order1, ReportOrderDto order2) {
                    if (order1.getAmount() > order2.getAmount()) {
                        return 1;
                    } else if (order1.getAmount() < order2.getAmount()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            reportLine.setMostExpensiveOrders(reportOrders.subList(0, Math.min(reportOrders.size(), numberOfExpensiveListed)));

            result.add(reportLine);
        }

        return result;
    }

    @Override
    public void generateRandomClientsWithOrders(int numberOfClients) {
        List<Client> clients = new ArrayList<>();

        for (int c = 0; c < numberOfClients; c++) {
            Client client = new Client();
            client.setFirstName("Jan");
            client.setLastName("Kowalski");
            client.setOrders(new ArrayList<Order>());

            int numberOfOrders = Math.abs(random.nextInt()) % 5;
            for (int i = 0; i <= numberOfOrders; i++) {
                Order order = new Order();
                order.setOrderDate(new Date());
                order.setOrderElements(new ArrayList<OrderElement>());

                int numberOfOrderElements = Math.abs(random.nextInt()) % 10;
                for (int j = 0; j <= numberOfOrderElements; j++) {
                    OrderElement element = new OrderElement();
                    element.setName("Some order");
                    element.setAmount(Math.abs(random.nextInt()) % 10000);
                    element.setOrder(order);

                    order.getOrderElements().add(element);
                }

                client.getOrders().add(order);
            }

            clients.add(client);
        }

        clientDao.saveClients(clients);
    }
}
