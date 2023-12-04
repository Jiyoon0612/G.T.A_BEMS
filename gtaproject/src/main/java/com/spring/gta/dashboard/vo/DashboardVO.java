/**
 * 
 */
package com.spring.gta.dashboard.vo;

/**
 * Class Name  : dashboardVO
 * Author      : ksj
 * Created Date: 2023. 11. 23.
 * Version: 1.0
 * Purpose:   
 * Description: 
 */
public class DashboardVO {
	 private float beTotalEnergy;
	 private float month;
	 private float bePlugEnergy;
	 private float beLightEnergy;
	 private float beAcEnergy;
	 
	    public DashboardVO() {
	    }

	    
	    public float getBePlugEnergy() {
			return bePlugEnergy;
		}


		public void setBePlugEnergy(float bePlugEnergy) {
			this.bePlugEnergy = bePlugEnergy;
		}


		public float getBeLightEnergy() {
			return beLightEnergy;
		}


		public void setBeLightEnergy(float beLightEnergy) {
			this.beLightEnergy = beLightEnergy;
		}


		public float getBeAcEnergy() {
			return beAcEnergy;
		}


		public void setBeAcEnergy(float beAcEnergy) {
			this.beAcEnergy = beAcEnergy;
		}


		public DashboardVO(float beTotalEnergy, float month) {
	        super();
	        this.beTotalEnergy = beTotalEnergy;
	        this.month = month;
	    }

	    public float getBeTotalEnergy() {
	        return beTotalEnergy;
	    }

	    public void setBeTotalEnergy(float beTotalEnergy) {
	        this.beTotalEnergy = beTotalEnergy;
	    }

	    public float getMonth() {
	        return month;
	    }

	    public void setMonth(float month) {
	        this.month = month;
	    }


		@Override
		public String toString() {
			return "DashboardVO [beTotalEnergy=" + beTotalEnergy + ", month=" + month + ", bePlugEnergy=" + bePlugEnergy
					+ ", beLightEnergy=" + beLightEnergy + ", beAcEnergy=" + beAcEnergy + "]";
		}

	   
	
}
