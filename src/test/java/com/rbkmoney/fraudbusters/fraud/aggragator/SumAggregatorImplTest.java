package com.rbkmoney.fraudbusters.fraud.aggragator;

import com.rbkmoney.fraudbusters.fraud.resolver.FieldResolver;
import com.rbkmoney.fraudbusters.repository.EventRepository;
import com.rbkmoney.fraudo.constant.CheckedField;
import com.rbkmoney.fraudo.model.FraudModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

public class SumAggregatorImplTest {

    @Mock
    private EventRepository eventRepository;
    @Mock
    private FieldResolver fieldResolver;
    @Mock
    private FieldResolver.FieldModel modelMock;

    SumAggregatorImpl sumAggregator;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(fieldResolver.resolve(any(), any())).thenReturn(modelMock);
        Mockito.when(eventRepository.sumOperationByField(any(), any(), any(), any())).thenReturn(10501L);

        sumAggregator = new SumAggregatorImpl(eventRepository, fieldResolver);
    }

    @Test
    public void sum() {
        Double some = sumAggregator.sum(CheckedField.BIN, new FraudModel(), 1444L);

        Assert.assertEquals(Double.valueOf(105.01), some);
    }

    @Test
    public void sumSuccess() {
        Double some = sumAggregator.sum(CheckedField.BIN, new FraudModel(), 1444L);

        Assert.assertEquals(Double.valueOf(105.01), some);
    }

    @Test
    public void sumError() {
        Double some = sumAggregator.sum(CheckedField.BIN, new FraudModel(), 1444L);

        Assert.assertEquals(Double.valueOf(105.01), some);
    }
}