package ingredients;

public class FoodSet {
	private Food[] foods;
	private int count;

	public FoodSet() {
		this.foods = new Food[1];
		this.count = 0;
	}

	public FoodSet(FoodSet other) throws NullPointerException{
		if(other == null) {
			throw new NullPointerException("FoodSet cannot be null");
		}
		else {
			int arrayLength = other.foods.length;

			this.foods = new Food[arrayLength];
			this.count = other.count;

			for(int i=0; i<arrayLength; i++) {
				if(other.foods[i] != null) {
					this.foods[i] = other.foods[i].clone();
				}
				else {
					this.foods[i] = null;
				}
			}
		}
	}

	@Override
	public FoodSet clone() {
		FoodSet copiedFoodSet = new FoodSet();
		int arrayLength = this.foods.length;
		copiedFoodSet.foods = new Food[arrayLength];
		copiedFoodSet.count = this.count;

		for(int i=0; i<arrayLength; i++) {
			if(this.foods[i] != null) {
				copiedFoodSet.foods[i] = this.foods[i].clone();
			}
			else {
				copiedFoodSet.foods[i] = null;
			}
		}
		return copiedFoodSet;
	}

	public boolean contains(Food food) throws NullPointerException{
		boolean gotIt = false;
		if(food == null) {
			throw new NullPointerException("This method cannot be used for looking for null");
		}
		else {
			int i = 0;
			while(!gotIt && i < this.foods.length) {
				if(this.foods[i] != null) {
					if(this.foods[i].getName().equals(food.getName()) && 
							this.foods[i].getPrice() == food.getPrice()) {
						gotIt = true;
					}
				}
				i++;
			}
		}
		return gotIt;
	}
	private void increaseLength() {
		int newLength = this.foods.length * 2;
		Food[] temporaryArray = new Food[newLength];

		for(int i=0; i<this.foods.length; i++) {
			if(this.foods[i] != null) {
				temporaryArray[i] = this.foods[i];
			}
		}
		this.foods = new Food[newLength];
		for(int i=0; i<newLength; i++) {
			if(temporaryArray[i] != null) {
				this.foods[i] = temporaryArray[i];
			}
		}
	}

	public boolean containsNull() {
		boolean gotNull = false;
		int i = 0;
		while(!gotNull && i<this.foods.length) {
			if(this.foods[i] == null) {
				gotNull = true;
			}
			i++;
		}
		return gotNull;
	}

	public int findFirstNull() {
		int position = -1;
		int i = 0;
		while(position == -1 && i<this.foods.length){
			if(this.foods[i] == null) {
				position = i;
			}
			i++;
		}
		return position;
	}

	public void add(Food food) throws NullPointerException{
		if(food != null && !contains(food)) {
			if(!containsNull()) {
				int addPosition = this.foods.length;
				increaseLength();
				this.foods[addPosition] = food.clone();
			}
			else {
				this.foods[findFirstNull()] = food.clone();
			}
			this.count++;
		}
		else if(food == null) { 
			System.out.println("You are not allowed to add null object!");
			throw new NullPointerException();
		}
		else if(contains(food)) {
			System.out.println("The food is already there.");
		}
	}

	public Food get(int index) {
		if(index >= 0 && index < this.count) {
			return this.foods[index] ;
		}
		return null;
	}

	public int getPositionSameName(String name) {
		int targetPosition = -1; 
		int i = 0;
		while(targetPosition == -1 && i < this.foods.length) {
			if(this.foods[i] != null) {
				if(this.foods[i].getName().equals(name)) {
					targetPosition = i;
				}
			}
			i++;
		}
		return targetPosition;
	}

	public Food get(String name) {
		if(getPositionSameName(name) == -1) {
			return null;
		}
		return this.foods[getPositionSameName(name)];
	}

	public boolean remove(String name) {
		boolean removeSuccess = false;
		int removePosition = getPositionSameName(name);
		if(removePosition != -1) {
			for(int i=removePosition; i<this.foods.length-1; i++) {
				if(this.foods[i+1] != null) {
					this.foods[i] = this.foods[i+1];
				}
				else {
					this.foods[i] = null;
				}
			}
			this.foods[this.foods.length-1] = null;
			removeSuccess = true;
			this.count -= 1;
		}
		return removeSuccess;
	}

	public int count() {
		return this.count;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int i=0; i<this.foods.length; i++) {
			if(this.foods[i] != null) {
				if(this.foods[i].getName() != null) {
					if(i != this.foods.length-1) {
						result.append(this.foods[i].getName()).append(", ");
					}
					else {
						result.append(this.foods[i].getName());
					}
				}
				else if(this.foods[i].getName() == null && i != this.foods.length-1) {
					result.append("null, ");
				}	
				else if(this.foods[i].getName() == null && i == this.foods.length-1) {
					result.append("null");
				}
			}
			else if(this.foods[i] == null && i == this.foods.length-1) {
				result.append("null ");
			}
			else if(this.foods[i] == null && i != this.foods.length-1) {
				result.append("null, ");
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		FoodSet newFoodSet = new FoodSet();
		FoodSet another = new FoodSet(newFoodSet);
		System.out.println(newFoodSet.count);
		System.out.println(another.count);
		FoodSet copy = newFoodSet.clone();
		System.out.println(copy.count);
		System.out.println(newFoodSet);
		System.out.println(another);
		System.out.println(copy);
	}
}
