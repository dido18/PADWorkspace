package clock.scalar;

public class ClockScalar implements ComparableClock {

	private int clock;
	private long id;
	private int delta;
	
	public ClockScalar(int pid, int delta){
		this.clock = 0;
		this.id = pid;
		this.delta = delta;
	}
	public ClockScalar(int id){
		this.clock = 0;
		this.id = id;
		this.delta = 1;
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	public int getClock() {
		return clock;
	}

	public void setClock(ClockScalar cs) {
		this.clock = cs.getClock();
	}

	public long getPid() {
		return id;
	}

	public void setPid(long pid) {
		this.id = pid;
	}
	
	public void ruleOne(){
		/*
		 * Rule number 1
		 */
		this.clock += this.delta;
	}
	

	public Occurred compare(ClockScalar cs) {
		Occurred occ;
		if(this.getClock() < cs.getClock())
			occ= Occurred.BEFORE;
		else if(this.getClock() == cs.getClock())
			occ=  Occurred.CONCURRENT;
		else
			occ = Occurred.AFTER;
		return occ;
	}
	
	
	
}
