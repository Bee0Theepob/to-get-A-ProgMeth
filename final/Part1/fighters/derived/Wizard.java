package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Wizard extends Unit implements Attackable {
	public  Wizard(int maxHealth, int speed, int power, int location) {
		super("Wizard", "w", maxHealth, speed, location, true);
		this.setRange(2);
		this.setPower(power);
	}
	public int attack(Unit e) {
		if((e.sameTeam(this)) || (!BattleUtils.validRange(this.getRange(),this.getLocation(),e.getLocation()))) {
			return -1;
		}
		else {
			return this.getPower();
		}
	}
}
