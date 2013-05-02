package com.hosp.bean;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import com.hosp.entities.*;
import com.hosp.dao.*;
import com.hosp.util.FormatUtils;

@ManagedBean
@ApplicationScoped
public class ListBean {

    SelectItem[] sexs;
    SelectItem[] countries;
    SelectItem[] maritalStatuses;
    SelectItem[] hours;
    SelectItem[] minutes;

    public SelectItem[] getSexs() {
        if (sexs == null) {
            SexDAO sexDAO = new SexDAO();
            List<Sex> temp = sexDAO.findAll();
            sexs = new SelectItem[temp.size() + 1];
            sexs[0] = new SelectItem("", "");
            int i = 1;
            for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
                Sex sex = (Sex) iterator.next();
                sexs[i] = new SelectItem(sex.getSexid(), sex.getName());
                i++;
            }
        }
        return sexs;
    }

    public void setSexs(SelectItem[] sexs) {
        this.sexs = sexs;
    }

    public SelectItem[] getCountries() {
        if (countries == null) {
            CountryDAO countryDAO = new CountryDAO();
            List<Country> temp = countryDAO.findAll(null);
            countries = new SelectItem[temp.size() + 1];
            countries[0] = new SelectItem("", "");
            int i = 1;
            for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
                Country country = (Country) iterator.next();
                countries[i] = new SelectItem(country.getCountryid(), country.getName() + " " + country.getAbbrevation());
                i++;
            }
        }
        return countries;
    }

    public void setCountries(SelectItem[] countries) {
        this.countries = countries;
    }

    public SelectItem[] getMaritalStatuses() {
        if (maritalStatuses == null) {
            MaritalstatusDAO MaritalstatusDAO = new MaritalstatusDAO();
            List<Maritalstatus> temp = MaritalstatusDAO.findAll();
            maritalStatuses = new SelectItem[temp.size() + 1];
            maritalStatuses[0] = new SelectItem("", "");
            int i = 1;
            for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
                Maritalstatus maritalstatus = (Maritalstatus) iterator.next();
                maritalStatuses[i] = new SelectItem(maritalstatus.getMaritalstatusid(),
                        maritalstatus.getName());
                i++;
            }
        }
        return maritalStatuses;
    }

    public void setMaritalStatuses(SelectItem[] maritalStatuses) {
        this.maritalStatuses = maritalStatuses;
    }

    public SelectItem[] getHours() {
        if (hours == null) {

            hours = new SelectItem[24];

            for (int j = 0; j < 24; j++) {
                String val = new Integer(j).toString();
                hours[j] = new SelectItem(FormatUtils.pad(val, 2), FormatUtils.pad(val, 2));
            }
        }
        return hours;
    }

    public void setHours(SelectItem[] hours) {
        this.hours = hours;
    }

    public SelectItem[] getMinutes() {
        if (minutes == null) {
            minutes = new SelectItem[60];
            for (int j = 0; j < 60; j++) {
                String val = new Integer(j).toString();
                minutes[j] = new SelectItem(FormatUtils.pad(val, 2), FormatUtils.pad(val, 2));
            }
        }
        return minutes;
    }

    public void setMinutes(SelectItem[] minutes) {
        this.minutes = minutes;
    }
}
