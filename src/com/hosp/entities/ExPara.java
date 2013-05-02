package com.hosp.entities;

import com.hosp.util.CheckUtil;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * ExPara entity.
 *
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EX_PARA", schema = "HOSPITAL")
@SequenceGenerator(name = "SEQ_EX_PARA", sequenceName = "EX_PARA_SEQ", allocationSize = 1)
public class ExPara implements java.io.Serializable {

    // Fields
    private BigDecimal parpapemptikoid;
    private ExContract exContract;
    private Hospital hospital;
    private ExTameio exTameio;
    private Country country;
    private Insurance insurance;
    private Patients patients;
    private ExAssertion exAssertion;
    private ExType exType;
    private ExPeriod exPeriod;
    private Users users;
    private ExParaType exParaType;
    private Date issuedate;
    private Date approvaldate;
    private Date executiondate;
    private String doctorcode;
    private String doctorname;
    private String doctorsurname;
    private String codctorcode;
    private String cdoctorname;
    private String cdoctorsurname;
    private String receiptnumber;
    private Date receiptdate;
    private BigDecimal enabled;
    private String codehealthunit;
    private String paracode;
    private BigDecimal paranumber;
    private Timestamp createdTimestamp;
    private List<ExParaExams> exParaExamses = new ArrayList<ExParaExams>(0);
    private BigDecimal totalAmount;
    

    // Constructors
    /**
     * default constructor
     */
    public ExPara() {
    }

    /**
     * minimal constructor
     */
    public ExPara(BigDecimal parpapemptikoid, ExContract exContract, Hospital hospital, Patients patients, ExPeriod exPeriod, Date issuedate,
            Date approvaldate, Date executiondate, BigDecimal paranumber, Timestamp createdTimestamp, ExType exType, String paracode) {
        this.parpapemptikoid = parpapemptikoid;
        this.exContract = exContract;
        this.hospital = hospital;
        this.patients = patients;
        this.exPeriod = exPeriod;
        this.issuedate = issuedate;
        this.approvaldate = approvaldate;
        this.executiondate = executiondate;
        this.paranumber = paranumber;
        this.createdTimestamp = createdTimestamp;
        this.paracode = paracode;
    }

    /**
     * full constructor
     */
    public ExPara(BigDecimal parpapemptikoid, ExContract exContract, Hospital hospital, ExTameio exTameio, Country country, Insurance insurance,
            Patients patients, ExAssertion exAssertion, ExPeriod exPeriod, Users users, ExParaType exParaType, Date issuedate, Date approvaldate,
            Date executiondate, String doctorcode, String doctorname, String doctorsurname, String codctorcode, String cdoctorname, String cdoctorsurname,
            String receiptnumber, Date receiptdate, BigDecimal enabled, String codehealthunit, BigDecimal paranumber, Timestamp createdTimestamp,
            List<ExParaExams> exParaExamses) {
        this.parpapemptikoid = parpapemptikoid;
        this.exContract = exContract;
        this.hospital = hospital;
        this.exTameio = exTameio;
        this.country = country;
        this.insurance = insurance;
        this.patients = patients;
        this.exAssertion = exAssertion;
        this.exPeriod = exPeriod;
        this.users = users;
        this.exParaType = exParaType;
        this.issuedate = issuedate;
        this.approvaldate = approvaldate;
        this.executiondate = executiondate;
        this.doctorcode = doctorcode;
        this.doctorname = doctorname;
        this.doctorsurname = doctorsurname;
        this.codctorcode = codctorcode;
        this.cdoctorname = cdoctorname;
        this.cdoctorsurname = cdoctorsurname;
        this.receiptnumber = receiptnumber;
        this.receiptdate = receiptdate;
        this.enabled = enabled;
        this.codehealthunit = codehealthunit;
        this.paranumber = paranumber;
        this.createdTimestamp = createdTimestamp;
        this.exParaExamses = exParaExamses;
        this.exType = exType;
    }

    // Property accessors
    @Id
    @Column(name = "PARPAPEMPTIKOID", unique = true, nullable = false, precision = 22, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EX_PARA")
    public BigDecimal getParpapemptikoid() {
        return this.parpapemptikoid;
    }

    public void setParpapemptikoid(BigDecimal parpapemptikoid) {
        this.parpapemptikoid = parpapemptikoid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTRACTID", nullable = false)
    public ExContract getExContract() {
        return this.exContract;
    }

    public void setExContract(ExContract exContract) {
        this.exContract = exContract;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HOSPITALID", nullable = false)
    public Hospital getHospital() {
        return this.hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAMEIOID")
    public ExTameio getExTameio() {
        return this.exTameio;
    }

    public void setExTameio(ExTameio exTameio) {
        this.exTameio = exTameio;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRYID")
    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "INSURANCEID")
    public Insurance getInsurance() {
        return this.insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PATIENTID", nullable = false)
    public Patients getPatients() {
        return this.patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ASSERTIONID")
    public ExAssertion getExAssertion() {
        return this.exAssertion;
    }

    public void setExAssertion(ExAssertion exAssertion) {
        this.exAssertion = exAssertion;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EXOTERIKATYPEID")
    public ExType getExType() {
        return this.exType;
    }

    public void setExType(ExType exType) {
        this.exType = exType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PERIODID", nullable = false)
    public ExPeriod getExPeriod() {
        return this.exPeriod;
    }

    public void setExPeriod(ExPeriod exPeriod) {
        this.exPeriod = exPeriod;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USERID")
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARATYPEID")
    public ExParaType getExParaType() {
        return this.exParaType;
    }

    public void setExParaType(ExParaType exParaType) {
        this.exParaType = exParaType;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ISSUEDATE", nullable = false, length = 7)
    public Date getIssuedate() {
        return this.issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "APPROVALDATE", nullable = false, length = 7)
    public Date getApprovaldate() {
        return this.approvaldate;
    }

    public void setApprovaldate(Date approvaldate) {
        this.approvaldate = approvaldate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "EXECUTIONDATE", nullable = false, length = 7)
    public Date getExecutiondate() {
        return this.executiondate;
    }

    public void setExecutiondate(Date executiondate) {
        this.executiondate = executiondate;
    }

    @Column(name = "DOCTORCODE", length = 40)
    public String getDoctorcode() {
        return this.doctorcode;
    }

    public void setDoctorcode(String doctorcode) {
        this.doctorcode = doctorcode;
    }

    @Column(name = "DOCTORNAME", length = 70)
    public String getDoctorname() {
        return this.doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    @Column(name = "DOCTORSURNAME", length = 100)
    public String getDoctorsurname() {
        return this.doctorsurname;
    }

    public void setDoctorsurname(String doctorsurname) {
        this.doctorsurname = doctorsurname;
    }

    @Column(name = "CODCTORCODE", length = 40)
    public String getCodctorcode() {
        return this.codctorcode;
    }

    public void setCodctorcode(String codctorcode) {
        this.codctorcode = codctorcode;
    }

    @Column(name = "CDOCTORNAME", length = 70)
    public String getCdoctorname() {
        return this.cdoctorname;
    }

    public void setCdoctorname(String cdoctorname) {
        this.cdoctorname = cdoctorname;
    }

    @Column(name = "CDOCTORSURNAME", length = 100)
    public String getCdoctorsurname() {
        return this.cdoctorsurname;
    }

    public void setCdoctorsurname(String cdoctorsurname) {
        this.cdoctorsurname = cdoctorsurname;
    }

    @Column(name = "RECEIPTNUMBER", length = 50)
    public String getReceiptnumber() {
        return this.receiptnumber;
    }

    public void setReceiptnumber(String receiptnumber) {
        this.receiptnumber = receiptnumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "RECEIPTDATE", length = 7)
    public Date getReceiptdate() {
        return this.receiptdate;
    }

    public void setReceiptdate(Date receiptdate) {
        this.receiptdate = receiptdate;
    }

    @Column(name = "ENABLED", precision = 22, scale = 0)
    public BigDecimal getEnabled() {
        return this.enabled;
    }

    public void setEnabled(BigDecimal enabled) {
        this.enabled = enabled;
    }

    @Column(name = "CODEHEALTHUNIT", length = 10)
    public String getCodehealthunit() {
        return this.codehealthunit;
    }

    public void setCodehealthunit(String codehealthunit) {
        this.codehealthunit = codehealthunit;
    }

    @Column(name = "PARACODE", length = 50)
    public String getParacode() {
        return paracode;
    }

    public void setParacode(String paracode) {
        this.paracode = paracode;
    }

    @Column(name = "PARANUMBER", nullable = false, precision = 22, scale = 0)
    public BigDecimal getParanumber() {
        return this.paranumber;
    }

    public void setParanumber(BigDecimal paranumber) {
        this.paranumber = paranumber;
    }

    @Column(name = "CREATED_TIMESTAMP", nullable = true, length = 11, insertable = false, updatable = true)
    public Timestamp getCreatedTimestamp() {
        return this.createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "exPara")
    public List<ExParaExams> getExParaExamses() {
        return this.exParaExamses;
    }

    public void setExParaExamses(List<ExParaExams> exParaExamses) {
        this.exParaExamses = exParaExamses;
    }

    @Transient
    public BigDecimal getTotalAmount() {
        try {
            totalAmount = BigDecimal.ZERO;
            for (ExParaExams paraExam : getExParaExamses()) {
                double temp = paraExam.getCost().doubleValue() * paraExam.getQuantity().doubleValue();
                totalAmount = totalAmount.add(BigDecimal.valueOf(temp));
            }
            return totalAmount;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Transient
    public BigDecimal getTotalParticipationAmount() {
        totalParticipationAmount = BigDecimal.ZERO;
        for (ExParaExams paraExam : exParaExamses) {
            totalParticipationAmount = totalParticipationAmount.add(paraExam.getTotalCost());
        }
        return totalParticipationAmount;
    }

    public void setTotalParticipationAmount(BigDecimal totalParticipationAmount) {
        this.totalParticipationAmount = totalParticipationAmount;
    }
    private BigDecimal totalParticipationAmount;

    
    private Boolean valid;
    
    @Transient
    public Boolean getValid() {
        if (patients != null && patients.getAmka() != null) {
            if (CheckUtil.checkAmka(patients.getAmka())) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ExPara)) {
            return false;
        }

        ExPara compare = (ExPara) obj;

        return compare.parpapemptikoid.equals(this.parpapemptikoid);
    }

    @Override
    public int hashCode() {
        return parpapemptikoid != null ? this.getClass().hashCode() + parpapemptikoid.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "ExPara{" + "id=" + parpapemptikoid + ", period=" + exPeriod + ", hospital=" + hospital + " assertion=" + exAssertion + " contract=" + exContract + "  }";
    }
}