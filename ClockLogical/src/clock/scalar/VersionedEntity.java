package clock.scalar;

public class VersionedEntity<T extends Entity>  {
	private ClockScalar clock;
	private T item;
	
	public VersionedEntity(T item) {
		this.clock =  new ClockScalar(item.getId()) ;
		this.item = item;
	}
	
	protected ClockScalar ruleTwo(ClockScalar cs){
		/*
		 *  Rule number 2
		 */
		    if(this.clock.compare(cs)==Occurred.AFTER)
	    	//if(this.clock.getClock()<cs.getClock())	   
			   this.clock.setClock(cs);
		   this.clock.ruleOne();
		   return this.clock;
		 //deliver the message to p
	}
	
	public void receive(ClockScalar cs){
		this.ruleTwo(cs);
	}
	
	public void send( VersionedEntity<Entity> receiver){
		this.clock.ruleOne();
		receiver.receive(this.getClock());
	}
	
	public void compute(){
		this.clock.ruleOne();
	}
	
	public ClockScalar getClock() {
		return clock;
	}

	public void setClock(ClockScalar clock) {
		this.clock = clock;
	}
	
	public Occurred compare( VersionedEntity<Entity> ve){
		return this.clock.compare(ve.getClock());
	}
	
	public String toString(){
		return "Entity No. "+this.item.getId()+" clock: "+this.clock.getClock()+"\n";
		
	}
	


}
