# Strings Service

Write RESTful web service that reads a collection of strings from request payload, sort them by provided comparison algorithm and feeds top 5 result into response processor.

Use interfaces and dependency injection to make the program flexible.

Provide an implementation of the interfaces which reads from JSON collection containing strings, sorts the input strings by the longest word contained in the string and feeds the output into JSON collection formatter, which prints JSON to response body. If there are several words of the same length "biggest by lexicographical comparison" should be selected among them.

For example request payload might contain:

```json
{
  "strings":[
    "Sound boy proceed to blast into the galaxy",
    "Go back rocket man into the sky you'll see",
    "Hear it all the time, come back rewind",
    "Aliens are watching up in the sky",
    "Sound boy process to blast into the galaxy",
    "No one gonna harm you",
    "They all want you to play I watch the birds of prey"
  ]
}
```

The program should select the strings 4, 5, 1, 2, 3 (in this order) and return following:

```json
{
  "result":[
    {
      "string":"Aliens are watching up in the sky",
      "longestWord":8
    },
    {
      "string":"Sound boy process to blast into the galaxy",
      "longestWord":7
    },
    {
      "string":"Sound boy proceed to blast into the galaxy",
      "longestWord":7
    },
    {
      "string":"Go back rocket man into the sky you'll see",
      "longestWord":6
    },
    {
      "string":"Hear it all the time, come back rewind",
      "longestWord":6
    }
  ]
}
```