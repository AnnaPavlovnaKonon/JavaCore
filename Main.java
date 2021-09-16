package homework1;

public class Main {
    public static void main(String [] args ) {
        Course [] courseArray = {new RoadForRunning(1000), new FieldForJumping(145)};
        Human[] teamArray = {
                new Human("Майкл", 140, 1000),
                new Human("Джим",160, 3000),
                new Human("Дуайт", 150, 2500),
                new Human("Пэм", 130, 1000)};
        Team team = new Team("Лучший офис", teamArray);
        Course course = new Course("Полоса препятствий: бег и прыжки в длину", courseArray);

        team.showInfo();
        team.competition(course);
        course.doIt(team);

    }
}
