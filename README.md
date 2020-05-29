# Build DSL in Kotlin

## Sample 1 - Binary Tree

```kotlin
val root =
  binaryTree(1) {
    left(2) {
      left(1)
        right(2)
    }
    right(3) {
      right(10)
    }
  }
```


