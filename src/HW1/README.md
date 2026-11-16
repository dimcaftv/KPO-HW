### Использование принципов SOLID по модулям:

- [App](src/main/java/ftv/App.java) - лучше всего реализован DIP (зависит только от абстракций)
- [UI](src/main/java/ftv/ui/ConsoleUI.java) - для простоты реализации консольного интерфейса, были ограничены ISP (
  большой интерфейс) и немного DIP (ui знает о всех типах предметов
  напрямую: [ItemTypes](src/main/java/ftv/items/ItemTypes.java))
- [Service](src/main/java/ftv/service/ServiceCenter.java) - для уменьшения количества зависимостей был нарушен SRP (
  ServiceCenter занимается достаточно разными операциями)
- [items](src/main/java/ftv/items) - т.к. иерархия предметов достаточно простая, то она соблюдает LSP и DIP
- В остальном из-за малого объема программы, принципы SOLID было сложно применить слишком явно

---

При добавлении нового вида транспорта нужно будет обновить только
enum [ItemTypes](src/main/java/ftv/items/ItemTypes.java) и
фабрику [ItemsFactory](src/main/java/ftv/items/ItemsFactory.java)

Если сотрудники и склад будут также реализовывать
интерфейс [IInventoryItem](src/main/java/ftv/items/IInventoryItem.java), то достаточно будет проделать те же шаги

--- 

Техосмотр и правило "для новичков" реализует [ServiceCenter](src/main/java/ftv/service/ServiceCenter.java) и тестируется
в [ServiceCenterImplTest](src/test/java/ftv/service/ServiceCenterImplTest.java)

В [AppMockTest](src/test/java/ftv/AppMockTest.java) зависимость подменяется с помощью мока, в остальных тестах
зависимость задается просто вручную

---

ИИ использовался только для консультации по работе с вводом-выводом в консоль на Java, но весь код был самостоятельно
написан с нуля