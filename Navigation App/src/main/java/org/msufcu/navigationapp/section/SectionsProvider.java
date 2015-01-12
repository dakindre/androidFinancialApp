package org.msufcu.navigationapp.section;

import org.msufcu.navigationapp.R;

import java.util.ArrayList;

/**
 * Created by kyle_000 on 2/6/14.
 */
public class SectionsProvider {
    public static ArrayList<Section> getSections() {
        ArrayList<Section> sections = new ArrayList<Section>();

        ArrayList<Section> creditTabs = new ArrayList<Section>();
        ArrayList<Section> wic = new ArrayList<Section>();

        wic.add(new SectionMore("Revolving credit", "(credit cards): you are given a maximum credit limit" +
                                                    " and every month you need to make a payment toward" +
                                                    " the balance or amount spent."));
        wic.add(new SectionMore("Charge cards", "You must pay the total balance every month"));
        wic.add(new SectionMore("Service credit", "Arrangements made with service providers such as " +
                                                  "electricity, cellular phone service, etc., and " +
                                                  "you make payments each month"));
        wic.add(new SectionMore("Installment credit", "(auto loan, mortgage): you are loaned a " +
                                                      "specific amount of money and agree to pay back " +
                                                      "the money with interest in set installments over" +
                                                      "a period of time."));
        creditTabs.add(new SectionListed("What is credit?", wic));
        creditTabs.add(new SectionMore("Why do I need credit?", "Because"));

        SectionTabbed creditNode = new SectionTabbed("Credit", creditTabs);
        creditNode.setAccentColors(R.color.accent_dark_credit, R.color.accent_light_credit);

        /*
        ArrayList<Section> budget = new ArrayList<Section>();
        budget.add(new SectionMore("What be a budget?", "Saving yo money foo"));
        budget.add(new SectionMore("How I can budget?", "Allocate money"));
        budget.add(new SectionMore("I'm out of ideas.", "For things to say about budgets"));
        SectionTabbed budgetNode = new SectionTabbed("Budget", budget);
        budgetNode.setAccentColors(R.color.accent_dark_budget, R.color.accent_light_budget);
        */
        sections.add(creditNode);
        // sections.add(budgetNode);
        // sections.add(new SectionMore("Travel tips", "Where has Drew's bag been?"));
        // sections.add(new SectionMore("International Students", "Where can I buy nice cars?"));
        return sections;
    }
}
