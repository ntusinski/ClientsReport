package com.softhis.service;

import com.softhis.dto.ReportLineDto;

import java.util.List;

public interface ClientService {
    List<ReportLineDto> getClientReport(int numberOfExpensiveListed) throws IllegalArgumentException;

    void generateRandomClientsWithOrders(int numberOfClients);
}
