

## Current flow

- _Topic 01:_ **BROKEN_CAR_TOPIC**
  - A `Car` produce a new `Event` when something is going wrong within its system.
    ```json
    {
      "carId": "UUID",
      "problemDescription": "String",
      "brokenDate": "Date"
    }
    ```
  - The `Event` is pushed into the `Topic 02`

- _Topic 02:_ **NEW_CAR_WITH_PROBLEM_ADDED_TOPIC**
  - Receive added `Event`
  - Add to `car_problem` table a new row with these values.
  - Return row created on `car_problem`.
  - Produce a new `Event` into _CAR_ADDED_TO_PROBLEM_TOPIC_
    ```json
    {
      "problemId": "UUID",
      "carId": "UUID"
    }
    ```

- _Topic 03:_ **CAR_ADDED_TO_PROBLEMS_TOPIC:**
  - Receive added `Event`
  - Pick up a `Repair Shop` [1]
  - Add a new entry on `car_to_repair_shop` with the values from the event.