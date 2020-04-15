<%--
  Created by IntelliJ IDEA.
  User: Microsoft Windows
  Date: 24/03/2020
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="service.CustomerService" %>
<%@ page import="service.CustomerServiceFactor" %>
<%!
    private CustomerService customerService = CustomerServiceFactor.getInstance();
%>
<%--<%--%>
<%--    Long id = Long.valueOf(request.getParameter("id"));--%>
<%--    Customer customer = customerService.findOne(id);--%>
<%--%>--%>
<form action="/customers" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <input type="hidden" name="id" value="${customer.id}">
        <table>
            <tr>
                <td>Id</td>
                <td>
                    ${customer.id}
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="${customer.name}">
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <input type="text" name="email" value="${customer.email}">
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <input type="text" name="address" value="${customer.address}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/customers">Back to list</a>.
