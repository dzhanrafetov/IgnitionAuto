package CarShopProject.Applicantss;

public class Applicant_SETTER {

        int numberofAppsdelivered;

        public Applicant_SETTER(int numberofAppsdelivered) {
            if (numberofAppsdelivered > 0) {
                this.numberofAppsdelivered = numberofAppsdelivered;
            }
        }

        public int getNumberOfAPPSDelivered() {
            return numberofAppsdelivered;
        }

        public void setNumberofAppsdelivered(int numberofAppsdelivered) {
            if (numberofAppsdelivered > 0) {
                this.numberofAppsdelivered = numberofAppsdelivered;
            }

        }
}
