package com.shipping.enumeration;

public enum CustomerOrderStatus {
	
        PLACED("Placed"),
        CONFIRMED("Confirmed"), 
        SHIPPED("Shipped"),
        DELIVERED("Delivered");
        
        private String value;
        
        private CustomerOrderStatus(String value) {
            this.value = value;
        }
    
        public String getValue() {
            return value;
        }

        public static void setValue(int nextInt) {
        }
    }