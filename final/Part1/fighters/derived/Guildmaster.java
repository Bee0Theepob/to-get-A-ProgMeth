package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Guardable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Guildmaster extends Unit implements Guardable,Attackable{
	public Guildmaster(int maxHealth, int speed, int power, int defense, int location) {
		super("Guildmaster", "G", maxHealth, speed, location, false);
		this.setRange(1);
		this.setPower(power);
		this.setDefense(defense);
		
	}
	public boolean move(int spaces) {
		return super.move(-1);
	}
	public void guard() {
		return;
	}
	public int attack(Unit e) {
		if((e.sameTeam(this)) || (!BattleUtils.validRange(this.getRange(),this.getLocation(),e.getLocation()))) {
			System.out.println(this.getLocation()+","+e.getLocation());
			return -1;
		}
		else {
			if(e.getDefense()==0) {
				return this.getPower();
			}
			return BattleUtils.calculateDamage(power, e) ;
		}
	}
}
