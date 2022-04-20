import ru.bulash.creatures.Cat;
import ru.bulash.creatures.Creature;
import ru.bulash.creatures.Human;
import ru.bulash.creatures.Robot;
import ru.bulash.tools.Tool;
import ru.bulash.tools.Track;
import ru.bulash.tools.Wall;

/*
Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
*/
public class Main {
	public static void main(String[] args) {
		Creature creatures[] = {
				new Human("Василий Петрович", 100, 2),
				new Human("Сергей Бубка", 200, 6),
				new Robot("R2D3", 20, 1),
				new Robot("Дэниел Р. Оливо", 800, 2),
				new Cat("Васька", 50, 1)
		};

		Tool tools[] = {
				new Track(40),
				new Wall(1),
				new Track(150),
				new Track(200),
				new Wall(1)
		};

		// Поехали
		for (Creature creature: creatures) {
			boolean passed = true;
			for (Tool tool: tools) {
				passed = passed && creature.action(tool);
			}
			if(passed) {
				creature.showDone();
			} else {
				creature.showDidnt();
			}
			System.out.println();
		}
	}
}