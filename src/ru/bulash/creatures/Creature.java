package ru.bulash.creatures;

import ru.bulash.tools.Tool;
import ru.bulash.tools.Track;
import ru.bulash.tools.Wall;

/*
Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
*/
public interface Creature {
	String getName();
	/**
	 * Наименование создания (creature)
	 *
	 * @return Название
	 */
	String getTitle();

	default void showToolAction(Tool tool) {
		System.out.printf("%s %s %s:\n", getTitle(), getName(), tool.getActionText());
	}

	default void showDone() {
		System.out.printf("%s %s завершил прохождение всех препятствий\n", getTitle(), getName());
	}

	default void showDidnt() {
		System.out.printf("%s %s не смог завершить прохождение всех препятствий\n", getTitle(), getName());
	}

	/**
	 * Бег
	 *
	 * @param tool Препятствие
	 * @return true - пробежал
	 */
	boolean run(Tool tool);

	/**
	 * Прыжок вверх
	 *
	 * @param tool Препятствие
	 * @return true - прыгнул
	 */
	boolean jump(Tool tool);

	default boolean action(Tool tool) {
		if(tool instanceof Track) {
			return this.run(tool);
		} else if (tool instanceof Wall) {
			return this.jump(tool);
		} else return false;
	}
}
