package com.invillia.acc;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Table(name = "acount")
public class Acount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accnumber", nullable = false)
    private  int accNumber;

    @Column(name = "accbalance", nullable = false)
    private double accBalance;

    @Column(name = "acclimit", nullable = false)
    private double accLimit;

    @Column(name = "username", nullable = false, length = 255)
    private String userName;

    @Column(name = "usercpf", nullable = false, length = 13)
    private String userCPF;

    @Column(name = "maxlimit", nullable = false)
    private double maxLimit;

    public void setAccLimit(double accLimit) {
        this.accLimit = accLimit;
        this.maxLimit = this.accLimit;
    }

    public Acount() {
    }

    public Acount(final int accNumber, final double accBalance, final double accLimit, final String userName, final String userCPF, final double maxLimit) {
        this.accNumber = accNumber;
        this.accBalance = accBalance;
        this.accLimit = accLimit;
        this.userName = userName;
        this.userCPF = userCPF;
        this.maxLimit = maxLimit;
    }

    @Override
    public String toString() {
        return "Acount " +
                "id=" + id +
                ", accNumber=" + accNumber +
                ", accBalance=" + accBalance +
                ", accLimit=" + accLimit +
                ", userName='" + userName + '\'' +
                ", userCPF='" + userCPF + '\'' +
                ", maxLimit=" + maxLimit +
                "\n" + '}';
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public double getAccLimit() {
        return accLimit;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCPF() {
        return userCPF;
    }

    public void setUserCPF(String userCPF) {
        this.userCPF = userCPF;
    }

    public double Deposit(double value){

        if(this.accBalance>=0 && this.accLimit == this.maxLimit){
            this.accBalance += value;
        }
        else if(this.maxLimit > this.accLimit){
                double auxDiffLocal = this.maxLimit - this.accLimit;
                if(value<=auxDiffLocal){
                    this.accLimit += value;
                }
                else{
                    this.accLimit += auxDiffLocal;
                    value -= auxDiffLocal;
                    this.accBalance += value;
                }
            }
        return  this.accBalance;
    }

    public double Withdrawn(double value) {
        if (this.accBalance + this.accLimit - value < 0) {
            JOptionPane.showMessageDialog(null,
                    "Saque negado!\nValor de limite ultrapassado.\nSaque novamente com um valor menor");
        } else if (this.accBalance >= value) {
            this.accBalance -= value;
        } else {
            this.accBalance -= value;
            this.accLimit += this.accBalance;
            this.accBalance=0;
        }
        return this.accBalance;
    }
}
