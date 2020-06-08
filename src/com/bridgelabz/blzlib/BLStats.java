package com.bridgelabz.blzlib;

public final class BLStats {
	
	private BLStats(){}
	
	// throw an IllegalArgumentException if x is null
    // (x is either of type double[] or int[])
    private static void validateNotNull(Object x) {
        if (x == null)
            throw new IllegalArgumentException("argument is null");
    }

    // throw an exception unless 0 <= lo <= hi <= length
    @SuppressWarnings("unused")
	private static void validateSubarrayIndices(int lo, int hi, int length) {
        if (lo < 0 || hi > length || lo > hi)
            throw new IllegalArgumentException("subarray indices out of bounds: [" + lo + ", " + hi + ")");
    }
	
	/**
     * Returns the maximum value in the specified array.
     *
     * @param  a the array
     * @return the maximum value in the array {@code a[]};
     *         {@code Double.NEGATIVE_INFINITY} if no such value
     */
    public static double max(double[] a) {
        validateNotNull(a);

        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (Double.isNaN(a[i])) return Double.NaN;
            if (a[i] > max) max = a[i];
        }
        return max;
    }
    
    /**
     * Returns the minimum value in the specified array.
     *
     * @param  a the array
     * @return the minimum value in the array {@code a[]};
     *         {@code Double.POSITIVE_INFINITY} if no such value
     */
    public static double min(double[] a) {
        validateNotNull(a);

        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (Double.isNaN(a[i])) return Double.NaN;
            if (a[i] < min) min = a[i];
        }
        return min;
    }
    
    /**
     * Returns the sum of all values in the specified array.
     *
     * @param  a the array
     * @return the sum of all values in the array {@code a[]};
     *         {@code 0.0} if no such value
     */
    private static double sum(double[] a) {
        validateNotNull(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    /**
     * Returns the average value in the specified array.
     * 
     * @param a the array
     * @return the average value in the array {@code a[]};
     * 			{@code Double.NaN} if no such value
     */
    public static double mean(double[] a){
    	validateNotNull(a);
    	
    	if(a.length == 0) return Double.NaN;
    	double sum = sum(a);
    	return sum/a.length;
    }
    
    /**
     * Returns the sample variance in the specified array.
     * 
     * @param a the array
     * @return the sample variance in the array {@code a[]};
     * 			{@code Double.NaN} if no such value
     */
    public static double var(double[] a){
    	validateNotNull(a);
    	
    	if(a.length == 0) return Double.NaN;
    	double avg = mean(a);
    	double sum = 0.0;
    	for (int i = 0; i < a.length; i++) {
    		sum += (a[i] - avg) * (a[i] - avg);
		}
    	return sum / (a.length-1);
    }
    
    /**
     * Returns the sample standard deviation in the specified array.
     * 
     * @param a the array
     * @return the sample standard deviation in the array{@code a[]};
     * 			{@code Double.NaN} if no such value
     */
    public static double stddev(double[] a){
    	validateNotNull(a);
    	return Math.sqrt(var(a));
    }

}
