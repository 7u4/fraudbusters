package com.rbkmoney.fraudbusters.service.template.insert.payment;

import com.rbkmoney.fraudbusters.domain.dgraph.common.DgraphPayment;
import com.rbkmoney.fraudbusters.service.template.AbstractDgraphTemplateService;
import com.rbkmoney.fraudbusters.service.template.TemplateService;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Service;

@Service
public class UpsertPaymentQueryTemplateService
        extends AbstractDgraphTemplateService implements TemplateService<DgraphPayment> {

    private static final String VELOCITY_VARIABLE_NAME = "payment";
    private static final String VELOCITY_TEMPLATE = "vm/insert/payment/upsert_payment_data_query.vm";

    public UpsertPaymentQueryTemplateService(VelocityEngine velocityEngine) {
        super(velocityEngine);
    }

    @Override
    public String build(DgraphPayment dgraphPayment) {
        return buildDgraphTemplate(VELOCITY_TEMPLATE, VELOCITY_VARIABLE_NAME, dgraphPayment);

    }

}
