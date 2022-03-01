#Code Review Defect List

**Reviewer: Garret Reichenbach | [Whitebox Branch](https://github.com/Garret-Reichenbach-ASU-Git/ser316-spring2022-C-greichen/tree/Whitebox)**

| ID  | Location                              | Description                                                                                               | Category | Severity |
|-----|---------------------------------------|-----------------------------------------------------------------------------------------------------------|----------|----------|
| 0   | Bear.java: 7-12                       | Attributes should be private.                                                                             | CG       | Medium   |
| 1   | BearWorkshop.java: 65                 | Method documentation is incorrectly formatted and includes very little information.                       | CG       | Low      |
| 2   | BearWorkshop.java: 105-107, 114-116   | Switch statement has duplicate branches.                                                                  | CS       | Low      |
| 3   | BearWorkshop.java: 40, 45             | List is updated but never actually used.                                                                  | CG       | Low      |
| 4   | BearWorkshop.java: 129-134, 140-145   | Code needlessly uses if statements when the boolean can just be returned directly.                        | CS       | Low      |
| 5   | BearWorkshop.java: 157-159            | Method returns -1 regardless of guardian's age.                                                           | FD       | High     |
| 6   | BearWorkshop.java: 162                | Double object isn't needed here, and neither is the call to Double.valueOf(). This should be a primitive. | CS       | Medium   |
| 7   | BearWorkshop.java: 163-168            | These can be reduced to a single loop.                                                                    | CS       | Medium   |
| 8   | BearWorkshop.java: 171, 183, 186, 188 | These variables are never used and should be removed.                                                     | CS       | Low      |