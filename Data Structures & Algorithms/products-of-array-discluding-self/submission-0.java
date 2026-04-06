class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int rightProduct = 1;
        Arrays.fill(products,1);
        for(int i = 1; i <nums.length; i++){
            rightProduct *= nums[i-1];
            products[i] = rightProduct;
        }
        int leftProduct = 1;
        for(int j = nums.length -2; j>=0; j--){
            leftProduct *= nums[j+1];
            products[j] *= leftProduct;
        }
        return products;
    }
}  
