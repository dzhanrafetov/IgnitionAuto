//package CarShopProject.Applicants;
//
//import java.util.ArrayList;
//
//import CarShopProject.Core_Store;
//import CarShopProject.Menu;
//
//import static CarShopProject.Applicants.Candidate.accepted_applicants;
//
//public class showEmployees {
//
//
//
//    public static void show(Core_Store coreStore) {
//
//        ArrayList<JobApplication> acc_app = new ArrayList<>(accepted_applicants);
//
//
//        //================================MECHANIC =============================
//        JobApplication mechanic_1 = new JobApplication("Pesho", "0324234", "secondary", 6, "mechanic", "");
//        JobApplication mechanic_2= new JobApplication("Dimitur", "0324234", "secondary", 6, "mechanic", "");
//
//        acc_app.add(mechanic_1);
//        acc_app.add(mechanic_2);
//
//        //================================AUTO ENGINEER=============================
//        JobApplication auto_engineer_1 = new JobApplication("Stilyan", "0324234", "high", 10, "engineer", "");
//        JobApplication auto_engineer_2= new JobApplication("Petur", "0324234", "high", 6, "engineer", "");
//
//        acc_app.add(auto_engineer_1);
//        acc_app.add(auto_engineer_2);
//
//        //================================TOW TRUCK DRIVER=============================
//        JobApplication tow_truck_driver_1 = new JobApplication("Martin", "0324234", "high", 6, "driver", "");
//
//        acc_app.add(tow_truck_driver_1);
//        //================================CAR SALESPERSON=============================
//        JobApplication car_salesperson_1 = new JobApplication("Yoana", "0324234", "high", 6, "salesperson", "");
//        JobApplication car_salesperson_2 = new JobApplication("Stefan", "0224234", "high", 6, "salesperson", "");
//        JobApplication car_salesperson_3 = new JobApplication("Yoan", "0524234", "high", 6, "salesperson", "");
//
//        acc_app.add(car_salesperson_1);
//        acc_app.add(car_salesperson_2);
//        acc_app.add(car_salesperson_3);
//
//        //================================VEHICLE INSPECTOR =============================
//        JobApplication vehicle_inspector_1 = new JobApplication("Tihomir", "0324234", "high", 6, "inspector", "");
//        JobApplication vehicle_inspector_2= new JobApplication("Angel", "0324234", "high", 6, "inspector", "");
//
//        acc_app.add(vehicle_inspector_1);
//        acc_app.add(vehicle_inspector_2);
//
//        //================================TIRE TECHNICIAN ==============================
//        JobApplication tire_technician_1 = new JobApplication("Alex", "0324234", "high", 6, "technician", "");
//
//        acc_app.add(tire_technician_1);
//
//
//
//        //===============================PRINTING=====================================
//        System.out.println("--------------------------------------------------------");
//        System.out.println("===================Our Employees========================");
//        System.out.println("--------------------------------------------------------");
//        System.out.println(" ");
//        System.out.println(" ");
//        for (JobApplication b : acc_app) {
//
//            System.out.println("===========EMPLOYEE ID ["+b.hashCode()+"] ====================");
//            System.out.println("-Name: "+b.getName());
//            System.out.println("-Position: "+b.getPosition_want());
//            System.out.println(" ");
//            System.out.println(" ");
//
//        }
//        Menu.menu(coreStore);
//    }
//
//}
//
//
