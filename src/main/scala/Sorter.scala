object Sorter {
  // Merges two subarrays of arr[].  // Merges two subarrays of arr[].
  // First subArray is arr[l..m]
  // Second subArray is arr[m+1..r]
  def merge(arr: Array[Int], l: Int, m: Int, r: Int): Unit = {
    // Find sizes of two subArrays to be merged
    val n1 = m - l + 1
    val n2 = r - m
    // Create temp arrays
    val L = new Array[Int](n1)
    val R = new Array[Int](n2)
    // Copy data to temp arrays
    for (i <- 0 until n1) {
      L(i) = arr(l + i)
    }
    for (j <- 0 until n2) {
      R(j) = arr(m + 1 + j)
    }
    // Merge the temp arrays
    // Initial indices of first and second subArrays
    var i = 0
    var j = 0
    // Initial index of merged subArray array
    var k = l
    while (i < n1 && j < n2) {
      if (L(i) <= R(j)) {
        arr(k) = L(i)
        i += 1
      }
      else {
        arr(k) = R(j)
        j += 1
      }
      k += 1
    }
    // Copy remaining elements of L[] if any
    while (i < n1) {
      arr(k) = L(i)
      i += 1
      k += 1
    }
    // Copy remaining elements of R[] if any
    while (j < n2) {
      arr(k) = R(j)
      j += 1
      k += 1
    }
  }

  // Main function that sorts arr[l..r] using
  // merge()
  def sort(arr: Array[Int], l: Int, r: Int): Unit = {
    if (l < r) {
      // Find the middle point
      val m = l + (r - l) / 2
      // Sort first and second halves
      sort(arr, l, m)
      sort(arr, m + 1, r)
      // Merge the sorted halves
      merge(arr, l, m, r)
    }
  }

  // A utility function to print array of size n
  def printArray(arr: Array[Int]): Unit = {
    val n = arr.length
    for (i <- 0 until n) {
      System.out.print(arr(i) + " ")
    }
    System.out.println()
  }

  // Driver code
  def main(args: Array[String]): Unit = {
    val arr = Array(12, 11, 13, 5, 6, 7)
    System.out.println("Given array is")
    printArray(arr)
    sort(arr, 0, arr.length - 1)
    System.out.println("\nSorted array is")
    printArray(arr)
  }
}
