This is an application made for CGI as part of their application process.

I unfortunately didn't have enough time to implement proper business logic. It does, however, have a scalable backend, and a frontend that displays flights, and when a flight's book button is clicked on, it directs to booking page that shows seats.

**How to use:**

1. Open the project in IntelliJ IDEA.

2. Run ``gradle bootrun`` to get the backend as well as the in-memory database working.

3. Navigate to frontend/flights-and-seats-front. There run command ``npm run dev``.

4. Open up the webpage in the recommended url - http://localhost:3000. (The backend runs at http://localhost:8080)

**How much was AI used?**

* I used AI a lot to help me think and explain things. Having a full understanding was the most important thing for me. I used AI to generate instructions for me to follow.

* I also used it to generate boilerplate code and sometimes some complex things.

* Since I didn't want AI to do everything for me, I wrote most of the
code by myself, because this project has also helped me learn. I didn't trust it blindly, but I reviewed everything and
basically used it as an extension to my previous knowledge.

* I mainly used ChatGPT, Copilot and Gemini. I had multiple tabs of copilot open to ask any new small questions that came up, which helped a lot
in understanding.


**Time spent on this**

Easily 15+ hours.

**Used stack**
* Spring Boot
* JPA
* Next.js (with TypeScript)
* React

**Used libraries**

I used Material-UI (https://mui.com/material-ui/react-table/)

**Database schema**

![Database schema I drew](./db_schema.png)