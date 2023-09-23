# Bank Account
Java API RESTful criada com SpringBoot

## Diagrama de classe
Desenvolvido utilizando IA Generativa com ChatGPT utilizando a sintaxe *Mermaid*

```mermaid
classDiagram
    class User {
        - name: string
        - account: Account
        - features: Feature[]
        - card: Card
        - news: News[]
    }

    class Account {
        - number: string
        - agency: string
        - balance: float
        - limit: float
    }

    class Feature {
        - icon: string
        - description: string
    }

    class Card {
        - number: string
        - limit: float
    }

    class News {
        - icon: string
        - description: string
    }

    User "1" *-- "1" Account
    User "1" *-- "n" Feature
    User "1" *-- "1" Card
    User "1" *-- "n" News
```


### Reference Documentation

* [Mermaid Diagramming and charting tool](https://mermaid.js.org/)