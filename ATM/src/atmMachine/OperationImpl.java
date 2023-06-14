package atmMachine;

import java.util.HashMap;
import java.util.Map;

public class OperationImpl implements OperationInterface{
    Atm atm=new Atm();
    Map<Double,String> ministmt=new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : "+atm.getBalance());

    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount%100==0) {
        	if(withdrawAmount !=0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministmt.put(withdrawAmount, " Withdrawn");
                System.out.println("Please collect the Cash ");
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }else {
        	System.out.println("Enter amount greater than zero");
        }
        }
        else {
            System.out.println("Please enter the amount in multipal of 100");
        }

    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount," Deposited");
        System.out.println(depositAmount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();

    }

    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+"   "+  m.getValue()+"   ");
        }

    }
}
