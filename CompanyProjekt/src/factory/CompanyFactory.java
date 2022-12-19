package factory;

import impl.CompanyImpl;
import inter.CompanyInter;

public class CompanyFactory {
    public static CompanyInter createdCompanyInter(String type){
        CompanyInter companyInter = null;
        switch (type){
            case "memory": companyInter = new CompanyImpl();
                break;
        }
        return companyInter;
    }
}
