package ru.bulash.creatures;

import ru.bulash.tools.Tool;

/*
Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
*/
// Человек
public class Human implements Creature {
	private String name;
	private int distance;
	private int height;

	public Human(String name, int distance, int height) {
		this.name = name;
		this.distance = distance;
		this.height = height;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getTitle() {
		return "Человек";
	}

	@Override
	public boolean run(Tool tool) {
		this.showToolAction(tool);
		if(tool.getLength() > this.distance) {
			System.out.printf("Человек не смог пробежать %d - предел %d\n", tool.getLength(), this.distance);
			return false;
		} else {
			System.out.printf("Человек пробежал %d\n", tool.getLength());
			this.distance -= tool.getLength();	// Накопительный эффект
			return true;
		}
	}

	@Override
	public boolean jump(Tool tool) {
		this.showToolAction(tool);
		if(tool.getLength() > this.height) {
			System.out.printf("Человек не смог прыгнуть вверх на %d - предел %d\n", tool.getLength(), this.height);
			return false;
		} else {
			System.out.printf("Человек прыгнул вверх на %d\n", tool.getLength());
			return true;
		}
	}
}
