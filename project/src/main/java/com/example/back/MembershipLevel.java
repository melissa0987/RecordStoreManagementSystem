package com.example.back;


public enum MembershipLevel{
    BRONZE,
    SILVER, 
    GOLD;

    
    //toString()
    public String toString(){
        String s = "";
        switch (this){
            case BRONZE: 
                return "Bronze";
            
            case SILVER:
                return "Silver";
            
            case GOLD:
                return "Gold";
        }
        return s;
    }

    public double gainedPoints( double purchase){
        double p = purchase;
        switch (this){
        case BRONZE: 
               return p;

            case SILVER:
            return purchase * 2;
            
            case GOLD:
            return purchase * 3;
        }
        return p;
    }

}
