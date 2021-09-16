package homework1;

    public class Team {
        private String teamName;
        Human[] teamArray;


        public Team(String teamName, Human[] teamArr) {
            this.teamName = teamName;
            this.teamArray = teamArr;
        }

        public Team() {

        }

        public Human[] getTeamArr() {
            return teamArray;
        }

        public void setTeamArr(Human[] teamArr) {
            this.teamArray = teamArr;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public void showInfo() {
            System.out.println("Команда " + teamName);
            System.out.println("Участники: ");
            for (Human t : teamArray) {
                System.out.println(t.getName() + " - длина прыжка " + t.getJumpLength() + " см" + ", максимальная дистанция для бега " + t.getRunLength() + " м");
            }
        }

        public void competition(Course course) {
            System.out.println("На старт");
            System.out.println("Внимание");
            System.out.println("Марш!");
        }


    }